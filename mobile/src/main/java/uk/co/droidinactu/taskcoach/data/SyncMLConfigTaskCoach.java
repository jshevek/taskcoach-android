package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class SyncMLConfigTaskCoach {

    @Element(name = "spds", required = false)
    public SyncMLConfigSpds spds;
}
