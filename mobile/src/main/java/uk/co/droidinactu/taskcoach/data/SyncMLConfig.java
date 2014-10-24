package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class SyncMLConfig {

    @Element(name = "TaskCoach-00000144bae7251d7d5886f5007f000000010001", required = false)
    public SyncMLConfigTaskCoach TaskCoach;
}
