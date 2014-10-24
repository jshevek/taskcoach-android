package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.xmlpull.v1.XmlPullParser;

@Root(strict = false)
public class Effort {
    private static final String LOG_TAG = Effort.class.getSimpleName();

    @Attribute(required = false)
    public String id = "";

    @Attribute(required = false)
    public String start = "";

    @Attribute(required = false)
    public String status = "";

    @Attribute(required = false)
    public String stop = "";

    private void setAttrs(final XmlPullParser xpp) {
        for (int attrIdx = 0; attrIdx < xpp.getAttributeCount(); attrIdx++) {
            final String attrName = xpp.getAttributeName(attrIdx);
            final String attrVal = xpp.getAttributeValue(attrIdx);

            if (attrName.equalsIgnoreCase("id")) {
                id = attrVal;

            } else if (attrName.equalsIgnoreCase("start")) {
                start = attrVal;

            } else if (attrName.equalsIgnoreCase("status")) {
                status = attrVal;

            } else if (attrName.equalsIgnoreCase("stop")) {
                stop = attrVal;
            }
        }
    }
}
