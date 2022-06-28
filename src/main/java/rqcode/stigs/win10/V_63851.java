package rqcode.stigs.win10;

import rqcode.patterns.win10.AvailableUserRightsAssignRequirement;

public class V_63851 extends AvailableUserRightsAssignRequirement {
    @Override
    protected String getFailure() {
        return null;
    }

    @Override
    protected String getInclusionSetting() {
        return "Allow log on locally";
    }

    @Override
    protected String getSuccess() {
        return "enable";
    }

    @Override
    public String checkTextCode() {
        return "C-81367r1_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63851";
    }

    @Override
    public String fixTextCode() {
        return "F-88439r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-78341r2_rule";
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
        return "WN10-UR-000025";
    }

    @Override
    public String description() {
        return "Inappropriate granting of user rights can provide system, administrative, and other high-level capabilities. Accounts with the \"Allow log on locally\" user right can log on interactively to a system.";
    }

    @Override
    public String getRights() {
        return "Administrators\n" +
                "Users";
    }
}

