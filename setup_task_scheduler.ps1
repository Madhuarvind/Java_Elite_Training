# PowerShell script to set up Windows Task Scheduler for daily commits

# Define the script path
$scriptPath = "C:\Users\Admin\OneDrive\Desktop\Data Structures and Alogithms\daily_commit.py"

# Define the task name
$taskName = "DailyCommitTask"

# Define the trigger (daily at 9 AM)
$trigger = New-ScheduledTaskTrigger -Daily -At "9:00AM"

# Define the action (run Python script)
$action = New-ScheduledTaskAction -Execute "python.exe" -Argument $scriptPath

# Define the principal (run with highest privileges)
$principal = New-ScheduledTaskPrincipal -UserId $env:USERNAME -LogonType Interactive -RunLevel Highest

# Create the task
Register-ScheduledTask -TaskName $taskName -Trigger $trigger -Action $action -Principal $principal -Description "Daily commit of one file"

Write-Host "Task Scheduler has been set up for daily commits at 9 AM."
