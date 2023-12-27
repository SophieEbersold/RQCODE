package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220865: WDigest Authentication must be disabled.. 
 */
public class V_220865 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Service",
            "attr", "AllowBasic",
            "result_value",  "0",
            "id", "V_220865"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM\\Service",
            "path_short", "HKLM:\\SOFTWARE\\Policies\\Microsoft\\Windows\\WinRM",
            "attr", "AllowBasic",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220865"),
            Map.entry("title", "WDigest Authentication must be disabled."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "high"),
            Map.entry("checktext", "If the system is configured to send audit records directly to an audit server, this is NA. This must be documented with the ISSO.\\n\\nIf the following registry value does not exist or is not configured as specified, this is a finding:\\n\\nRegistry Hive: HKEY_LOCAL_MACHINE\\nRegistry Path: \\SOFTWARE\\Policies\\Microsoft\\Windows\\EventLog\\Security\\\\n\\nValue Name: MaxSize\\n\\nValue Type: REG_DWORD\\nValue: 0x000fa000 (1024000) (or greater)"),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> Windows Components >> Windows Remote Management (WinRM) >> WinRM Service >> \\Allow Basic authentication\\ to \\Disabled\\.\\n\\nSeverity Override Guidance: The AO can allow the severity override if they have reviewed the overall protection. This would only be allowed temporarily for implementation as documented and approved. \\n….\\nAllowing Basic authentication to be used for the sole creation of Office 365 DoD tenants.\\n….\\nA documented mechanism and or script that can disable Basic authentication once administration completes. \\n….\\nUse of a Privileged Access Workstation (PAW) and adherence to the Clean Source principle for administration."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Basic authentication uses plain text passwords that could be used to compromise a system."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000345")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220865() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220865();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
