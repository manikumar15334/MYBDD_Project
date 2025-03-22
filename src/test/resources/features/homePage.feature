Feature: Verify login page scenarios
  As a tester, I want to check revenue calculator options

  Background:
    Given Open vtiger application homepage

    @regression @homepage
      Scenario:Validate the slider's position is updated to reflect the value
      And Navigate to revenue calculator home page
      And scroll down to the revenue calculator slider section
      And Update "820" value to slider text field
      And See the slider is adjusted to the updated value
      And Update "560" value to slider text field
      And See the slider is adjusted to the updated value
      And Select cpt checkboxes "CPT-99091, CPT-99453, CPT-99454,CPT-99474"
      Then Validate the selected cpt codes is selected