junit-parameters
================

It is about finding best solution for running parameterized JUnit tests. JUnit parameterized test has one problem they don't allow parameterization on method level. Sometimes it is waste to create separate class for each method you want to run with parameters. Due to that fact I would like to have nice parameterization solution in my toolkit.

There are a few extensions which are aimed to fill the gap. I want to find the one that best fits my needs.

My needs:
- must be compatible with JUnit,
- be able to run parameterized method,
- managed through pom.xml,
- easy in setup and use.

Tested extensions (so far):
- com.googlecode.zohhak / zohhak
- pl.pragmatists / JUnitParams
- com.tngtech.java / junit-dataprovider
- org.easetech / easytest-core
- org.databene / feed4junit

Not checked (yet):
- net.sf.twip / twip
- org.callbackparams / callbackparams
