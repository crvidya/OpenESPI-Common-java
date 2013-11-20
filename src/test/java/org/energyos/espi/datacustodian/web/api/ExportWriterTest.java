package org.energyos.espi.datacustodian.web.api;


import org.energyos.espi.common.BaseTest;
import org.energyos.espi.common.models.atom.EntryType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.servlet.ServletOutputStream;
import javax.xml.transform.Result;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;

public class ExportWriterTest extends BaseTest {

    @Mock
    private ServletOutputStream os;
    @Mock
    private Jaxb2Marshaller marshaller;

    private ExportWriter writer;

    @Before
    public void before() {
        writer = new ExportWriter();
        writer.setOutputStream(os);
        writer.setMarshaller(marshaller);
    }

    @Test
    public void write() {
        EntryType entry = new EntryType();
        writer.write(entry);
        verify(marshaller).marshal(eq(entry), any(Result.class));
    }
}
