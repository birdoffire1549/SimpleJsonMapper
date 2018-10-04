# SimpleJsonMapper
API: This is a Simple JSON Mapper API. 
The idea is to make it SUPER EASY, EFFICIENT and QUICK to get information from a JSON string.
<br>
The project can be built into a JAR using Gradle with the following command:<br>
<br>
`gradle clean build`<br>
<br>
This will create the JAR artifact which can be included in any Java project as a dependency.
From there one only needs to create and instance of the SimpleJsonMapper object and give it the String representation of the JSON one wishes to fetch values from, via its constructor.
Then, making calls to the getValue method of the SimpleJsonMapper Object one can fetch the desired data from the JSON, using simply its data path.<br>
<br>
Example:<br>
<br>
SimpleJsonMapper jMapper = new SimpleJsonMapper(jsonString);<br>
Long desiredValue1 = jMapper.getValue("record_count").getAsLong();<br>
String desiredValue2 = jMapper.getValue("people[1].first_name");
