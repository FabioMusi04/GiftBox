---
icon: settings
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

# Configuration

GiftBox comes with a `config.yml` file that allows you to customize plugin behavior, messages, and item display.

When you first run the plugin, the configuration file is automatically generated in:

```

plugins/GiftBox/config.yml

````

---

## Configuration Options

### Gift Box Display Name

The name displayed on the wrapped item:

```yaml
gift-box:
  name: "Gift Box"
````

### Namespaced Key

The key used internally to store the wrapped item:

```yaml
gift-box:
  key: "stored_item"
```

You usually won’t need to change this unless you are managing multiple plugins with similar storage keys.

---

## Example Full Configuration

```yaml
gift-box:
  name: "Gift Box"
  key-namespace: "giftbox"
  key-value: "stored_item"
```

---

## Tips

* Always backup your `config.yml` before making changes.
* Changes to the config require a server reload or restart to take effect.