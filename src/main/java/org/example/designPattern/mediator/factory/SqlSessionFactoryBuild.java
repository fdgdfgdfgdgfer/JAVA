package org.example.designPattern.mediator.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.designPattern.mediator.configuration.Configuration;
import org.example.designPattern.mediator.model.XNode;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author jfz
 * @Date 2024/3/6 16:16
 * @PackageName:org.example.designPattern.mediator.factory
 * @ClassName: SqlFactoryBuild
 */
@Data
@NoArgsConstructor
public class SqlSessionFactoryBuild {

    public SqlSessionFactory build(Reader reader) throws Exception {
        //buil获取xml文件里mapper方法,
        //解析xml文件
        SAXReader saxReader = new SAXReader();
        //装载
        saxReader.setEntityResolver(new XMLMapperEntityResolver());
        //获取xml转化为InputStreamReader的document对象以操作xml文件
        Document read = saxReader.read(new InputSource(reader));
        Configuration configuration = parseConfiguration(read.getRootElement());
        return new SqlSessionFactory(configuration);

    }

    /**
     * 通过docment获取xml配置
     */
    private Configuration parseConfiguration(Element root) {
        String text = root.getText();
        Configuration configuration = new Configuration();
        configuration.setDataSour(dataSource(root.selectNodes("//dataSource")));
        configuration.setConnection(connection(configuration.dataSour));
        configuration.setMapper(mapperElement(root.selectNodes("mappers")));
        return configuration;
    }

    /**
     * 数据源连接信息
     */
    private Map<String, String> dataSource(List<Element> list) {
        HashMap<String, String> hashMap = new HashMap<>();
        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            hashMap.put(name, value);
        }
        return hashMap;
    }

    /**
     * 获取数据源
     */
    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"),
                    dataSource.get("username"),
                    dataSource.get("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * mapper信息
     */
    private Map<String, XNode> mapperElement(List<Element> list) {
        Map<String, XNode> map = new HashMap<>();

        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String resource = e.attributeValue("resource");

            try {
                Reader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element root = document.getRootElement();
                //命名空间
                String namespace = root.attributeValue("namespace");

                // SELECT
                List<Element> selectNodes = root.selectNodes("select");
                for (Element node : selectNodes) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    // ? 匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for (int i = 1; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);
                    xNode.setParameter(parameter);

                    map.put(namespace + "." + id, xNode);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return map;
    }

}
