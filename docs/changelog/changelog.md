---
description: This document tracks all significant updates to the GiftBox plugin.
---

# Changelog

{% stepper %}
{% step %}
**Version 1.0.0**

1. Start by initializing your application with version 1.0.0. This serves as the baseline version for your project.

* Initial Release

**Released:** 2025-08-14

#### Added

* `/giftbox` command for item wrapping.
* Base64 item serialization for secure gift box storage.
* PersistentDataContainer for wrapping items within ItemStacks.
* MiniMessage support for custom item names and descriptions.
* Configurable `config.yml` options:
  * Gift box display name
  * Internal storage identifier
* Sound effect on successful item wrap.
* Basic permissions to ensure player-only command usage.
{% endstep %}
{% endstepper %}

***

{% hint style="info" %}
This is the first public release. Feedback, bug reports, and feature requests are encouraged!
{% endhint %}
