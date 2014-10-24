package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class SyncML {

    @Element(required = false)
    public String Auth;

    @Element(required = false)
    public String Conn;
}
