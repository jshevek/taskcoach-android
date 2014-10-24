package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

@Root(strict = false)
public class Note {
    private static final String LOG_TAG = Note.class.getSimpleName();
    @Element(required = false)
    public String description = "";
    @Attribute(required = false)
    private String creationDateTime;
    @Attribute(required = false)
    private String id;

    @Attribute(required = false)
    private boolean m_readingDescription;

    @Attribute(required = false)
    private String modificationDateTime;

    @Attribute(required = false)
    private String status;

    @Attribute(required = false)
    private String subject;

    public void parseXml(final XmlPullParser xpp, final int lvlNbr) throws XmlPullParserException, IOException {

        setAttrs(xpp);

        // Log.d(Task.LOG_TAG, "task [" + this.subject + "] parsing");

        String text = xpp.getText();
        int eventType = xpp.next();
        String tagname = xpp.getName();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG: {
                    if (tagname.equalsIgnoreCase("note")) {
                    }
                    if (tagname.equalsIgnoreCase("description")) {
                        m_readingDescription = true;
                    }
                    break;
                }

                case XmlPullParser.TEXT: {
                    text = xpp.getText();
                    if (m_readingDescription) {
                        description += text;
                    }
                    break;
                }

                case XmlPullParser.END_TAG: {
                    if (tagname.equalsIgnoreCase("note")) {
                        // Log.d(Task.LOG_TAG, "task [" + this.subject +
                        // "] finished");
                        return;
                    } else if (tagname.equalsIgnoreCase("description")) {
                        m_readingDescription = false;
                    }
                    break;
                }

                default:
                    break;
            }
            eventType = xpp.next();
            tagname = xpp.getName();
        }
    }

    private void setAttrs(final XmlPullParser xpp) {
        for (int attrIdx = 0; attrIdx < xpp.getAttributeCount(); attrIdx++) {
            final String attrName = xpp.getAttributeName(attrIdx);
            final String attrVal = xpp.getAttributeValue(attrIdx);

            if (attrName.equalsIgnoreCase("id")) {
                id = attrVal;

            } else if (attrName.equalsIgnoreCase("creationDateTime")) {
                creationDateTime = attrVal;

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
