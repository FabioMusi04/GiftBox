# GiftBox Plugin for Minecraft

**GiftBox** is a simple Minecraft plugin that allows players to wrap any item into a customizable gift box with a message. Perfect for gifting items between players!

---

## Features

- Wrap any item in a **Gift Box**.
- Add a **custom message** and sender name.
- Open a gift to retrieve the original item.
- Play particle effects and sounds when opening a gift.
- Fully configurable display name and message formatting via `config.yml`.
- Supports Adventure `MiniMessage` formatting.

---

## Installation

1. Download the latest `.jar` from the [Releases](#) section.
2. Place the `.jar` into your server’s `plugins` folder.
3. Start or restart the server.
4. A `config.yml` file will be generated in `plugins/GiftBox`.

---

## Commands
```

/giftbox <message>

````

- Wraps the item in your main hand into a gift box.
- Optional `<message>` will appear inside the gift box.
- Example: `/giftbox Happy Birthday!`

---

## Configuration (`config.yml`)

```yaml
gift-box:
  name: "Gift Box"
  key-namespace: "giftbox"
  key-value: "stored_item"
  default-message: "No message"
```

* **gift-box.name**: The display name for the gift box (supports MiniMessage formatting).
* **gift-box.key-namespace** and **gift-box.key-value**: Used internally to store items inside gift boxes.
* **gift-box.default-message**: The message shown when the player doesn’t provide one.

> ⚠️ **Do not** commit secrets or sensitive values to GitHub. Your `config.yml` can be safely published as it only contains plugin settings.

---

## Code Structure

* **GiftBoxCommand.java** – Handles `/giftbox` command. Wraps items and applies messages.
* **GiftBoxListener.java** – Handles opening gift boxes, retrieving the stored item, and playing effects.
* **GiftBoxUtils.java** – Serializes and deserializes items to store them inside gift boxes using Base64.

### Example Usage in Code

```java
GiftBox plugin = GiftBox.getPlugin(GiftBox.class);
String giftBoxName = plugin.getConfig().getString("gift-box-name", "Gift Box");
```

Use Adventure `PlainTextComponentSerializer` when comparing display names to ensure proper matching.

---

## Contribution

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

---

## License

MIT License. See `LICENSE` for details.

---

## Notes

* Supports Minecraft 1.19+ with Adventure API.
* Tested on Spigot and Paper servers.
* Use Adventure MiniMessage formatting for colors and styles.