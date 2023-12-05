package rqcode.stigs.win10_new.RegistryEdit.stigs;

import rqcode.stigs.win10_new.RegistryEdit.RegistryEditConst;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditPattern;
import rqcode.stigs.win10_new.RegistryEdit.RegistryEditScriptPattern;

import java.util.Map;

public class V_220872 extends RegistryEditPattern {
    private final RegistryEditScriptPattern policyScriptPattern =
            new RegistryEditScriptPattern(
                    RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_CHECK, RegistryEditConst.REGISTRY_EDIT_SCRIPT_PATTERN_ENFORCE,
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
                            "attr", "DisableThirdPartySuggestions",
                            "result_value", "1",
                            "id", "V_220872"
                    ),
                    Map.of(
                            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\CloudContent",
                            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows",
                            "attr", "DisableThirdPartySuggestions",
                            "result_value", "1"
                            
                        ),
                    Map.of(
                            "description", "Users must not be allowed to ignore Windows Defender SmartScreen filter warnings for malicious websites in Microsoft Edge."
                        )
                );


    public V_220872() {
        pattern = this.policyScriptPattern;
    }


}
