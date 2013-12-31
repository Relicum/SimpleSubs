SimpleSubs - Making Sub Commands Easier
------------------

Instructions to follow
---

Setup
---
Download the latest JAR from https://relicum.ci.cloudbees.com/job/SimpleSubs/

You next to add this to your build path.

If using maven dependency

```xml
        <dependency>
            <groupId>com.relicum</groupId>
            <artifactId>SimpleSubs</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
```

Maven Repo

```xml
        <repository>
            <id>cloudbees-private-release-repository</id>
            <url>https://repository-relicum.forge.cloudbees.com/release/</url>
        </repository>
```

Setting Sub Command in Plugin.yml
----

This will set up a Sub command we can use called /gold

```yml
commands:
   gold:
     description: Main Sub Command for gold plugin
     aliases: gld
     permission: gold.admin
     usage: /gold [command] [args]

 permissions:
     gold.admin.*
         description: Gives player access to all commands
         children:
             gold.admin: true
```