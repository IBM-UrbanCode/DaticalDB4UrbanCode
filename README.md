IBM UrbanCode Deploy and Build DaticalDB Plugin [![Build Status](https://travis-ci.org/IBM-UrbanCode/DaticalDB-UCD-UCB.svg?branch=master)](https://travis-ci.org/IBM-UrbanCode/DaticalDB-UCD-UCB)
=================

This plugin brings Datical DB functionality to IBM UrbanCode Deploy and Build.

Two properties in the plugin step, Datical DB Install Directory and Datical DB Drivers Directory, read a default property at the resource (Agent) level. For each agent that is going to execute Datical DB, create a Resource Property called daticalDBCmd and daticalDBDriversDir.  

Note: This is not the plug-in distributable! The full plugin can be found under the releases tab.

### License
This plug-in is protected under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0)

### Compatibility
	This plug-in requires version 6.1.1 or later of IBM UrbanCode Deploy.
    This plug-in requires version 6.1.0 or later of IBM UrbanCode Build.


Release Notes:

### Version 23 - September 27, 2017

Added Pipeline parameter to Deploy Command

### Version 22.223 - October 25, 2016

Community GitHub Release

### Version 1.220 - December 3, 2015

Rebranding for UrbanCode as plugin works for both Deploy and Build

### Version 1.219 - March 10, 2015

	- Added support for arbitrary Groovy Script execution.
	- NOTE: need to create target directory prior to running "Create Datical DB Project"

### Version 1.213 - March 4, 2015

	- Added support for creating new projects using our project_creator.groovy script. New Step Name is "Create Datical DB Project".
	- Added support for baselining existing projects using our project_baseline.groovy script. New Step Name is "Register and Baseline Datical DB Project"

### Version 1.195 - March 3, 2015

	- Added support for "show version"
	- Changed naming for steps to correspond to new icons usage in UrbanCode Deploy 6.1.1.1

### Version 1.183 - January 27, 2015

 - Added support for Labels in Forecast.

### Version 1.180 - January 12, 2015

 - Added support for Labels in Deploy and Diff Change Log.

### Version 1.176 - December 1, 2014

 - Fixed issue with "Datical DB JVM Arguments" in Groovy scripts. NOTE: not bumping internal version number.

### Version 1.175 - November 19, 2014

- Fixed bug with Deploy Threshold values in plugin.xml.
- Fixed bug in deploy.groovy script that prevented the Deploy step from working.

### Version 1.169 - November 18, 2014

To support customers that wish to dynamically choose the JVM when Datical DB is executed, the command line now supports two new arguments:

 - --vm Path to a JDK install
 - --vmargs JVM arguments

The JVM arguments must be the LAST thing on the command line.

Examples:
> $ hammer show version --vm /usr/lib/jvm/java-7-openjdk-amd64 --vmargs -Xmx1024M

> C:\Users\wesley\product\repl>.\hammer.bat show version --vm "C:\Program Files\Java\jdk1.7.0_17" --vmargs -Dmx1024M

Thus, we've added new new text boxes to each Datical DB Step, Datical DB JVM and Datical DB JVM Arguments. Neither are required.

There is a known issue with placing multiple arguments in the "Datical DB JVM Arguments" text box. IBM Rational UrbanCode Deploy passes all properties as quoted strings. Thus, *--vmargs -Xms512M -Dmx512M* becomes *--vmargs "-Xms512M -Dmx512M"*. We are working with IBM on a resolution to this issue.
