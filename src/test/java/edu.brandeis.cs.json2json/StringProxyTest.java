package edu.brandeis.cs.json2json;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class StringProxyTest {

    String [] paths = new String []{
        "$.store.book[*].author",
        "$..author",
        "$..book[(@.length-1)]",
        "$..book[?(@.price<10)]"
    };

    String json = "    {\n" +
            "    \"@context\": {\n" +
            "    \"name\": \"http://schema.org/name\",\n" +
            "    \"homepage\": {\n" +
            "    \"@id\": \"http://schema.org/url\",\n" +
            "    \"@type\": \"@id\"\n" +
            "    },\n" +
            "    \"image\": {\n" +
            "    \"@id\": \"http://schema.org/image\",\n" +
            "    \"@type\": \"@id\"\n" +
            "    }\n" +
            "    },\n" +
            "    \"image\": \"http://manu.sporny.org/images/manu.png\",\n" +
            "    \"name\": \"Manu Sporny\",\n" +
            "    \"homepage\": \"http://manu.sporny.org/\"\n" +
            "    }";

    String jsonTemplate = "{\n" +
            "\"@context\": { \"&$.@context.homepage.*\" },\n" +
            "\"homepage\": \"&$.homepage\"\n" +
            "}";

    String[] tempatePaths = new String []{
            "&$.@context.homepage.*",
            "&$.homepage"
    };

    @Before
    public void setup() throws Exception{

    }

    @After
    public void tear() {}

    @Test
    public void test(){
        String t = StringProxy.split("hello.world", "\\.");
        Assert.assertEquals("[\"hello\",\"world\"]",t);

        t = StringProxy.join("[\"hello\",\"world\"]", ".");
        Assert.assertEquals("hello.world",t);

        t = StringProxy.join("[\"hello\",\"world\"]", ".");
        Assert.assertEquals("hello.world",t);

        t = StringProxy.regex_match("hello.world", "[a-z]+");
        Assert.assertEquals("[\"hello\",\"world\"]",t);
    }
    
}