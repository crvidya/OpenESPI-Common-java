package org.energyos.espi.datacustodian.web.api;

import org.energyos.espi.common.models.atom.EntryType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ExportWriter {
    private ServletOutputStream servletOutputStream;
    private Jaxb2Marshaller marshaller;

    public void write(EntryType entry) {
        try {
            servletOutputStream.write(marshal(entry));
            servletOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] marshal(EntryType entry) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(entry, new StreamResult(os));

        return os.toByteArray();
    }

    public void setMarshaller(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setOutputStream(ServletOutputStream outputStream) {
        this.servletOutputStream = outputStream;
    }
}
