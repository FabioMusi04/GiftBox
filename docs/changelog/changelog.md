---
description: This document tracks all significant updates to the GiftBox plugin.
---

# Changelog

## Changelog

This document tracks all significant updates to the GiftBox plugin.

### \[1.0.0] - Initial Release

**Released:** 2025-08-14

#### Added

* `/giftbox` command for item wrapping.
* Base64 item serialization for secure gift box storage.
* PersistentDataContainer for wrapping items within ItemStacks.
* MiniMessage support for custom item names and descriptions.
* Configurable `config.yml` options:
  * Gift box display name
  * Internal storage identifier
  * User messages for wrapping and errors
* Sound effect on successful item wrap.
* Basic permissions to ensure player-only command usage.

#### Fixed

* None (first release)

#### Known Issues

* Display name may not support all MiniMessage formats.
* Stacked item wrapping not available.

***

{% hint style="info" %}
This is the first public release. Feedback, bug reports, and feature requests are encouraged!
{% endhint %}
