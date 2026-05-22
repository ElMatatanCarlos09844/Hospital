# Script para convertir README.md a PDF

$readmeFile = "C:\Users\Carlos Cisneros\Documents\NetBeansProjects\Hospital\README.md"
$htmlFile = "C:\Users\Carlos Cisneros\Documents\NetBeansProjects\Hospital\README.html"
$pdfFile = "C:\Users\Carlos Cisneros\Documents\NetBeansProjects\Hospital\README.pdf"

# Leer el contenido de markdown
$markdown = Get-Content $readmeFile -Raw

# Convertir markdown a HTML
$html = @"
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital - Sistema de Gestión de Médicos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
            color: #333;
        }
        h1 {
            color: #2c3e50;
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
            page-break-after: avoid;
        }
        h2 {
            color: #34495e;
            margin-top: 30px;
            page-break-after: avoid;
        }
        code {
            background: #ecf0f1;
            padding: 2px 6px;
            border-radius: 3px;
            font-family: 'Courier New', monospace;
        }
        pre {
            background: #2c3e50;
            color: #ecf0f1;
            padding: 15px;
            border-radius: 5px;
            overflow-x: auto;
            page-break-inside: avoid;
        }
        li {
            margin: 8px 0;
        }
        img {
            max-width: 100%;
            height: auto;
            margin: 20px 0;
            page-break-inside: avoid;
        }
        blockquote {
            background: #f8f9fa;
            border-left: 4px solid #3498db;
            padding: 10px 15px;
            margin: 10px 0;
        }
        a {
            color: #3498db;
            text-decoration: none;
        }
    </style>
</head>
<body>
"@

# Procesar líneas
$lines = $markdown -split "`n"
$inCodeBlock = $false
$htmlContent = ""

foreach ($line in $lines) {
    if ($line -match "^```") {
        if ($inCodeBlock) {
            $htmlContent += "</pre>`n"
            $inCodeBlock = $false
        } else {
            $htmlContent += "<pre>`n"
            $inCodeBlock = $true
        }
    } elseif ($inCodeBlock) {
        $htmlContent += "$line`n"
    } elseif ($line -match "^# (.+)$") {
        $heading = $Matches[1]
        $htmlContent += "<h1>$heading</h1>`n"
    } elseif ($line -match "^## (.+)$") {
        $heading = $Matches[1]
        $htmlContent += "<h2>$heading</h2>`n"
    } elseif ($line -match "^- (.+)$") {
        $item = $Matches[1]
        # Procesar inline formatting
        $item = $item -replace '`([^`]+)`', '<code>$1</code>'
        $htmlContent += "<li>$item</li>`n"
    } elseif ($line -match "^> (.+)$") {
        $quote = $Matches[1]
        $htmlContent += "<blockquote>$quote</blockquote>`n"
    } elseif ($line -match "^!\[(.+?)\]\((.+?)\)") {
        $alt = $Matches[1]
        $src = $Matches[2]
        $htmlContent += "<img src=`"$src`" alt=`"$alt`">`n"
    } elseif ($line.Trim() -ne "") {
        # Procesar formatos inline
        $line = $line -replace '\*\*(.+?)\*\*', '<strong>$1</strong>'
        $line = $line -replace '`([^`]+)`', '<code>$1</code>'
        $line = $line -replace '\[(.+?)\]\((.+?)\)', '<a href="$2">$1</a>'
        $htmlContent += "<p>$line</p>`n"
    } else {
        $htmlContent += "`n"
    }
}

$html += $htmlContent
$html += "</body></html>"

# Guardar HTML
Set-Content -Path $htmlFile -Value $html -Encoding UTF8

# Convertir HTML a PDF usando PowerShell (requiere Word o similar)
$wdFormatPDF = 17
$msWord = New-Object -ComObject Word.Application

try {
    $msWord.Visible = $false
    $document = $msWord.Documents.Open($htmlFile, $null, $null, $true)
    $document.SaveAs2($pdfFile, $wdFormatPDF)
    $document.Close()
    Write-Host "PDF creado exitosamente: $pdfFile"
} catch {
    Write-Host "Error al crear PDF: $_"
    Write-Host "Si Word no está instalado, puedes abrir el archivo HTML generado: $htmlFile"
} finally {
    $msWord.Quit()
}
