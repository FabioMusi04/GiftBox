---
icon: download
layout:
  width: default
  title:
    visible: true
  description:
    visible: true
  tableOfContents:
    visible: true
  outline:
    visible: true
  pagination:
    visible: true
  metadata:
    visible: true
---

# Installation

The **GiftBox** plugin allows players to wrap any in-game item into a gift box, store it securely, and give it to other players.

Follow these steps to install it on your Minecraft server.

---

## Requirements

- **Minecraft Server:** Spigot, Paper, or Purpur (1.19+ recommended)
- **Java:** JDK 17 or newer

---

## 1. Download the Plugin

1. Download the latest `GiftBox-x.x.x.jar` from:
   - [Releases on GitHub](https://github.com/FabioMusi04/GiftBox/releases)
   - or your chosen distribution site (e.g., SpigotMC, Modrinth)

2. Save the `.jar` file to your computer.

---

## 2. Install on Your Server

1. Navigate to your server's root folder.
2. Place the `GiftBox-x.x.x.jar` into the `plugins` directory.
3. Start (or restart) your server.

---

## 3. Verify Installation

1. In the server console, look for:
```

\[GiftBox] Plugin enabled successfully!

````
2. In-game, run:
```text
/giftbox
````

If you see the help message, the plugin is installed.

---

## 4. Configuration

When the server first runs with GiftBox installed, it will create:

```
plugins/GiftBox/config.yml
```

Here you can configure:

* **Gift box display name**
* **NamespacedKey** for stored item data
* Any plugin messages

Example:

```yaml
gift-box:
  name: "Gift Box"
  key-namespace: "giftbox"
  key-value: "stored_item"
```

---

## 5. Updating the Plugin

1. Download the new `.jar` from GitHub or SpigotMC.
2. Replace the old `.jar` in `plugins/` with the new file.
3. Restart your server.

> **Info:**  
> Always back up your server before updating plugins.