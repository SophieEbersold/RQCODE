package rqcode.stigs.win10_v3.RegEdit;

import java.util.Map;

import rqcode.stigs.win10_v3.WinScriptHelper;

/**
 * V_220797: Remote Desktop Services must be configured with the client connection encryption set to the required level.. 
 */
public class V_220797 extends RegEditStig {

    /**
     * Initiating parameters for the check script
     */
    private final static Map<String, String> CHECK_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
            "attr", "EnableICMPRedirect",
            "result_value",  "0",
            "id", "V_220797"
            );
    /**
     * Initiating parameters for the enforce script
     */
    private final static Map<String, String> ENFORCE_VALUES = Map.of(
            "path", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters",
            "path_short", "HKLM:\\SYSTEM\\CurrentControlSet\\Services\\Tcpip",
            "attr", "EnableICMPRedirect",
            "result_value", "0"
            );
    /**
     * Initiating information defining the security requirements from the STIG
     * database
     */
    private final static Map<String, String> INFO = Map.ofEntries(
            Map.entry("id", "V_220797"),
            Map.entry("title", "Remote Desktop Services must be configured with the client connection encryption set to the required level."),
            Map.entry("date", "2021-08-18"),
            Map.entry("ruleID", "SV_220699r569187_rule"),
            Map.entry("severity", "low"),
            Map.entry("checktext", "Verify the effective setting in Local Group Policy Editor.\\nRun \\gpedit.msc\\.\\n\\nNavigate to Local Computer Policy >> Computer Configuration >> Windows Settings >> Security Settings >> Account Policies >> Password Policy.\\n\\nIf the value for \\Store password using reversible encryption\\ is not set to \\Disabled\\ this is a finding."),
            Map.entry("checkid", "C-22414r642137_chk"),
            Map.entry("fixtext", "Configure the policy value for Computer Configuration >> Administrative Templates >> MSS (Legacy) >> \\MSS: (EnableICMPRedirect) Allow ICMP redirects to override OSPF generated routes\\ to \\Disabled\\.\\n\\nThis policy setting requires the installation of the MSS-Legacy custom templates included with the STIG package. \\MSS-Legacy.admx\\ and \\ MSS-Legacy.adml\\ must be copied to the \\Windows\\PolicyDefinitions and \\Windows\\PolicyDefinitions\\en-US directories respectively."),
            Map.entry("fixid", "F-22403r554583_fix"),
            Map.entry("description","Allowing ICMP redirect of routes can lead to traffic not being routed properly.  When disabled, this forces ICMP to be routed via shortest path first."),
            Map.entry("iacontrols", "null"),
            Map.entry("version", "WN10-CC-000030")
            );

    /**
     * Setting up STIG information and initializing the windows script helper with
     * the check and enforce parameters
     */
    public V_220797() {
        setStigInfo(INFO);
        WinScriptHelper helper = this.getHelper();
        helper.setCheckValues(CHECK_VALUES);
        helper.setEnforceValues(ENFORCE_VALUES);
    }

    /**
     * Simple test for the STIG check
     */
    public static void main(String[] args) {
        RegEditStig stig = new V_220797();

        stig.check();
        System.out.println(stig);

        // stig.enforce();
        // stig.check();

        //System.out.println(stig);



    }

}
