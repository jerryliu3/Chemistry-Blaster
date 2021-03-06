; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{24D18B8B-13E6-46F2-8C9A-AD647B7144C7}
AppName=Chemistry Blaster
AppVersion=5.0
;AppVerName=Chemistry Blaster 5.0
AppPublisher=IJ Computers of Science
DefaultDirName={pf}\Chemistry Blaster
DisableDirPage=yes
DefaultGroupName=Chemistry Blaster
DisableProgramGroupPage=yes
InfoAfterFile=C:\Users\MONKEY\Desktop\Most Updated\More updated\README.txt
OutputDir=C:\Users\MONKEY\Desktop\Most Updated\More updated
OutputBaseFilename=Chemistry Blaster Setup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\MONKEY\Desktop\Most Updated\More updated\ChemistryBlaster.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\MONKEY\Desktop\Most Updated\More updated\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\Chemistry Blaster"; Filename: "{app}\ChemistryBlaster.jar"
Name: "{commondesktop}\Chemistry Blaster"; Filename: "{app}\ChemistryBlaster.jar"; Tasks: desktopicon

[Run]
Filename: "{app}\ChemistryBlaster.jar"; Description: "{cm:LaunchProgram,Chemistry Blaster}"; Flags: shellexec postinstall skipifsilent

