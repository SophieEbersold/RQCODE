package rqcode.stigs.win10_v3.AuditPolicy;

import rqcode.stigs.STIG;
import rqcode.stigs.win10_v3.WinScriptHelper;

import java.util.Map;

/**
 * V_220761: Windows 10 must be configured to audit Object Access - File Share failures.
 */
public class V_220761 extends AuditPolStig {
        /**
         * Initiating parameters for the check script
        */
        private final static Map<String, String> CHECK_VALUES = Map.of(
                        "id", "V_220761",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "subcat_es", "errores",
                        "subcat_eng", "failure"
                        );

        /**
         * Initiating parameters for the enforce script
         */
        private final static Map<String, String> ENFORCE_VALUES = Map.of(
                        "id", "V_220761",
                        "guid", "{0CCE923F-69AE-11D9-BED3-505054503030}",
                        "parameter", "Failure",
                        "value", "enable"
                        );
        /**
         * Initiating information defining the security requirements from the STIG
         * database
         */
        private final static Map<String, String> INFO = Map.ofEntries(
                        Map.entry("id", "V_220761"),
                        Map.entry("title", "Windows 10 must be configured to audit Object Access - File Share failures."),
                        Map.entry("date", "2021-08-18"),
                        Map.entry("ruleID", "SV-220761r569187_rule"),
                        Map.entry("severity", "medium"),
                        Map.entry("checktext", "Security Option "Audit: Force audit policy subcategory settings (Windows Vista or later) to override audit policy category settings" must be set to "Enabled" (WN10-SO-000030) for the detailed auditing subcategories to be effective.

Use the AuditPol tool to review the current Audit Policy configuration:

Open PowerShell or a Command Prompt with elevated privileges ("Run as Administrator").

Enter "AuditPol /get /category:*"

Compare the AuditPol settings with the following:

Object Access >> File Share - Failure

If the system does not audit the above, this is a finding."),
                        Map.entry("checkid", "C-22468r554744_chk"),
                        Map.entry("fixtext", "Computer Configuration >> Windows Settings >> Advanced Audit Policy Configuration >> System Audit Policies >> Detailed Tracking >> "Audit PNP Activity" with "Success" selected."),
                        Map.entry("fixid", "F-22457r554745_fix"),
                        Map.entry("description","Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior.

Plug and Play activity records events related to the successful connection of external devices."),
                        Map.entry("iacontrols", "None"),
                        Map.entry("version", "WN10-AU-000081"),
                        );
                    
        /**
         * Setting up STIG information and initializing the windows script helper with
         * the check and enforce parameters
         */
        public V_220761() {
                setStigInfo(INFO);
                WinScriptHelper helper = this.getHelper();
                helper.setCheckValues(CHECK_VALUES);
                helper.setEnforceValues(ENFORCE_VALUES);
        }

        /**
         * Simple test for the STIG check
         */
        public static void main(String[] args) {
                STIG stig = new V_220761();

                System.out.println(stig);

                stig.check();
                System.out.println("1st check:" + stig.getLastCheckStatus());
        }

}