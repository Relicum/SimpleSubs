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

You also need to set a depend in the plugin.yml

```yml
depend: [SimpleSubs]


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

Getting a reference to SimpleSubs in your plugin
---

Provided you have the SimpleSubs in your build path, in the OnEnable section add the following.
This will create a hook to SimpleSubs and also create an instance of the command register.

```java
Simplesubs ss = (Simplesubs) getServer().getPluginManager().getPlugin("SimpleSubs");
registerCommand rg = ss.getCommandRegister();
```

