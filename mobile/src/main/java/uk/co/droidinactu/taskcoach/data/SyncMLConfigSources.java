package uk.co.droidinactu.taskcoach.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class SyncMLConfigSources {

    @Element(name = "TaskCoach-00000144bae7251d7d5886f5007f000000010001.Tasks", required = false)
    public String tasks;
    @Element(name = "TaskCoach-00000144bae7251d7d5886f5007f000000010001.Notes", required = false)
    public String notes;
}
