// Extracts one of the values from CSS 'style' attribute. assume we have:
// style="display: block; opacity: 1; transform: translate(-50%, 414px);"
// valueName 'opacity' will extract 1 from that

public static String extractStyleAttributeValue(String attributeValues, String valueName) {
        Pattern valuePattern = Pattern.compile(format("%s: (.*?);", valueName));
        Matcher matcher = valuePattern.matcher(attributeValues);
        if (matcher.find()) {
            return matcher.group(1);
        } else { return ""; }
    }
