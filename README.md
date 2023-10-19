# jackson-deserialization-lab
A Security Lab to test and practice Jackson Deserialization Vulnerability 


# Steps
1. Host the spel.xml on a VPS/localhost server
2. In the payload.json, replace the x.x.x.x with the IP of VPS/localhost where the spel.xml is hosted.


# About Jackson Deserialization
1. Accept Json input controlled by Attacker
2. Enable Polymorphic Type Handling:
	- om.enableDefaultTyping()           and om.readValue(userInput, Bruh.class) where Bruh.java should have a property of Object. (java.io.Serializable, java.util.Comparable)
	- mapper.setDefaultTyping(null)      and om.readValue(userInput, Bruh.class) where Bruh.java should have a property of Object. (java.io.Serializable, java.util.Comparable)
	- om.readValue(userInput, Bruh.class)  where Bruh.class has a property of type of Object with @JsonTypeInfo(use = Id.CLASS) set on that property.
3. Has at least one specific “gadget” class to exploit in the Java classpath and also that Gadget Class must work with Jackson.
4. Use version of Jackson that does not (yet) block “gadget” class in question (set of published exploits grows over time so it is a race between exploits and patches)


# Note
Blacklisted Gadgets: https://github.com/FasterXML/jackson-databind/blob/12e23c962ffb4cf1857c5461d72ae54cc8008f29/src/main/java/com/fasterxml/jackson/databind/jsontype/impl/SubTypeValidator.java <br>
Amazing Read: https://cowtowncoder.medium.com/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062 
