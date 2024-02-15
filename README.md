# MiniMExpansion
MiniMExpansion is a PAPI expansion that helps you make color codes in placeholders work in plugins that use [MiniMessage](https://docs.advntr.dev/minimessage/index.html).

## How to use?
`%minim_<placeholder>%` - Converts legacy color codes with ampersand (&) in the placeholder to the MiniMessage format.

**Example:** `&c&lTest` -> `<bold><red>Test`.
**Usage example**: `%minim_vault_prefix%`

### Section (§) colors?

If the placeholder returns the section color codes (You can determine this by using `/papi parse` command if the colors are actually applying).
**Use** `%minim_section_<placeholder>%`

**Example:** `§c§lTest` -> `<bold><red>Test`.
**Usage example**: `%minim_section_server_tps_colored%`