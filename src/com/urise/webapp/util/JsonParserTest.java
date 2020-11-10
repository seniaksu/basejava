package com.urise.webapp.util;

import com.urise.webapp.model.AbstractSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SingleTextSection;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static com.urise.webapp.ResumeTestData.fillResume;

public class JsonParserTest {
    private static final String UUID_1 = UUID.randomUUID().toString();
    private static final Resume r1 = fillResume(UUID_1, "Name1");
    @Test
    public void testResume() throws Exception {
        String json = JsonParser.write(r1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(r1, resume);
    }

    @Test
    public void write() throws Exception {
        AbstractSection section1 = new SingleTextSection("Objective1");
        String json = JsonParser.write(section1, AbstractSection.class);
        System.out.println(json);
        AbstractSection section2 = JsonParser.read(json, AbstractSection.class);
        Assert.assertEquals(section1, section2);
    }
}
