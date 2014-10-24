package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * <category creationDateTime="2014-03-18 14:30:07.301733"
 * expandedContexts="('categoryviewerintaskeditor',)"
 * id="cd9495b6-aea9-11e3-a5d6-c80aa9eb1588"
 * modificationDateTime="2014-03-18 14:30:10.009758" status="1" subject="Bug" />
 *
 * @author andy
 */
@Root(strict = false)
public class Category {
    private static final String LOG_TAG = Category.class.getSimpleName();

    @Attribute(required = false)
    public String id;

    @Attribute(required = false)
    public String expandedContexts;

    @Attribute(required = false)
    public String categorizables;

    @Attribute(required = false)
    public String status;

    @Attribute(required = false)
    public String modificationDateTime;

    @Attribute(required = false)
    public String subject;

    @Attribute(required = false)
    public String creationDateTime;

    public void setAttrs(final XmlPullParser xpp) throws XmlPullParserException, IOException {

        for (int attrIdx = 0; attrIdx < xpp.getAttributeCount(); attrIdx++) {
            final String attrName = xpp.getAttributeName(attrIdx);
            final String attrVal = xpp.getAttributeValue(attrIdx);
            if (attrName.equalsIgnoreCase("expandedContexts")) {
                expandedContexts = attrVal;
            } else if (attrName.equalsIgnoreCase("creationDateTime")) {
                creationDateTime = attrVal;
            } else if (attrName.equalsIgnoreCase("id")) {
                id = attrVal;
            } else if (attrName.equalsIgnoreCase("modificationDateTime")) {
                modificationDateTime = attrVal;
            } else if (attrName.equalsIgnoreCase("status")) {
                status = attrVal;
            } else if (attrName.equalsIgnoreCase("subject")) {
                subject = attrVal;
            }
        }
    }

}
