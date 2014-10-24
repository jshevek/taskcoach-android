package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Attachment {
    private static final String LOG_TAG = Attachment.class.getSimpleName();

    @Attribute(required = false)
    public String creationDateTime = "";

    @Element(required = false)
    public String description = "";

    @Attribute(required = false)
    private String id;

    @Attribute(required = false)
    private String location;

    @Attribute(required = false)
    private String modificationDateTime;

    @Attribute(required = false)
    private String status;

    @Attribute(required = false)
    private String subject;

    @Attribute(required = false)
    private String type;

}
