# WarCraft: Monolith

![](http://warcraft.gg/image/wcgg-logo.png)

Monolith is an effort by WarCraft to open source its code and get involved with the Minecraft plugin community. It is the result of collecting common functionality encountered during years of server development and its purpose is to provide a more convenient API for certain aspects of creating Minecraft plugins. Despite the name, Monolith does not encourage the similarly named anti-pattern, but actually tries to steer the consumer towards proper modularization and composition over inheritance by design. You will find that most modules are written in an immutable style to improve testability and reduce side effects. The project takes some elements from Domain Driven Design (DDD) to improve project structure, but by no means attempts to implement it to its full potential.

## Work in progress
The Monolith project is a work in progress and as such you might run into block types or events that have not yet been implemented. When you do please open an issue on our GitHub at [github.com/WarCraft/Monolith](https://github.com/WarCraft/Monolith) and we will do our best to implement it as quickly as we can. Alternatively you can look into implementing the missing piece yourself and opening a pull request. More on contributing below.

## Ask questions
We open source our code for everyone's benefit. If you run into a concept or snippet that you don't understand do not hesitate to ask a question in the #dev channel on our Discord at [discord.warcraft.gg](http://discord.warcraft.gg) or in the development category on our forum at [community.warcraft.gg](http://community.warcraft.gg) and we'll do our best to explain what it does, how it does it, and share our thoughts on why we felt that's how it should do it.

## Contributing
If you run into a concept or snippet that you feel could be improved please do get in touch via the aforementioned channels, or through a pull request, and we can discuss potential changes. In addition you could pick up a task from our YouTrack board at [warcraft.myjetbrains.com](https://warcraft.myjetbrains.com/youtrack), but more on that in the future. To enable collaboration we impose a minimal set of house rules:
- The API layer will be fully documented at all times
- The application layer will enjoy extensive automated testing wherever appropriate

## Plugins
Modules that have use cases as standalone plugins will eventually be provided as simple downloads. Other, more niche, implementations will have to be provided on the class path or fat compiled into your own plugins. We're looking into getting our artifacts on Maven Central.
