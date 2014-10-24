package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class SyncMLConfigSpds {

    @Element(name = "sources", required = false)
    public SyncMLConfigSources sources;

    @Element(name = "syncml", required = false)
    public SyncML syncml;

}
