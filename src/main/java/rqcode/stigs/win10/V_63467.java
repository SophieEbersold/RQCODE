package rqcode.stigs.win10;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import rqcode.stigs.win10.patterns.LogonRequirement;

/**
 * Maintaining an audit trail of system activity logs can help identify configuration errors, troubleshoot service disruptions, and analyze compromises that have occurred, as well as detect attacks. Audit logs are necessary to provide a trail of evidence in case the system or network is compromised. Collecting this data is essential for analyzing the security of information assets and detecting signs of suspicious and unexpected behavior. Logon records user logons. If this is an interactive logon, it is recorded on the local system. If it is to a network share, it is recorded on the system accessed.
 * 
 * https://www.stigviewer.com/stig/windows_10/2016-10-28/finding/V-63467
 */

public class V_63467 extends LogonRequirement {
    
    @Override
    protected String getFailure() {
        return null;
    }

    
    @Override
    protected String getInclusionSetting() {
        return "Success";
    }

    
    @Override
    protected String getSuccess() {
        return "enable";
    }

    
    @Override
    public String checkTextCode() {
        return "C-64215r1_chk";
    }

    
    @Override
    public String date() {
        return "2020-06-15";
    }

    
    @Override
    public String findingID() {
        return "V-63467";
    }

    
    @Override
    public String fixTextCode() {
        return "F-69395r1_fix";
    }

    
    @Override
    public String iAControls() {
        return "";
    }

    
    @Override
    public String ruleID() {
        return "SV-77957r1_rule";
    }

    
    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    
    @Override
    public String severity() {
        return "Medium";
    }

    
    @Override
    public String version() {
        return "WN10-AU-000075";
    }

}
