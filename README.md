# ktor-hilt-room
Ktor, Hilt, Room Application


## TEST for PowerShell

```
$jobs = @()

# Launch 100 jobs
for ($i = 1; $i -le 100; $i++) {
    $url = "http://192.168.1.141:8888/test1/erkan/kaplan/342523/1"  # Adjust URL as needed
    $jobs += Start-Job -ScriptBlock {
        param($url)
        Invoke-RestMethod -Uri $url -Method Get
    } -ArgumentList $url
}

# Wait for all jobs to finish
Wait-Job -Job $jobs

# Collect results from all jobs
$results = $jobs | ForEach-Object { Receive-Job -Job $_ }

# Clean up jobs
$jobs | Remove-Job

# Output the results
$results

```