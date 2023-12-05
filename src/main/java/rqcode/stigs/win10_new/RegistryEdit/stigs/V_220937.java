package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220937 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "attr", "NoLMHash",
                            "result_value", "1",
                            "id", "V_220937"
                    ),
                    Map.of(
                            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa",
                            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Control",
                            "attr", "NoLMHash",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "If Enhanced diagnostic data is enabled it must be limited to the minimum required to support Windows Analytics."
                        )
                );


    public V_220937() {
        pattern = this.policyScriptPattern;
    }


}
