# PAPIMiniColors
PAPIMiniColors is a PAPI expansion that helps you make color codes in placeholders work in MiniMessage-format plugins.

## How to use?
`%papiminicolors_<placeholder>%` - Converts legacy color codes with ampersand (&) in the placeholder to the minimessage format.

**Example:** `&c&lTest` -> `<bold><red>Test`.
**Usage example**: `%papiminicolors_vault_prefix%`

### Section (§) colors?

If the placeholder returns the section color codes (You can determine this by using `/papi parse` command if the colors are actually applying).
**Use** `%papiminicolors_section_<placeholder>%`

**Example:** `§c§lTest` -> `<bold><red>Test`.
**Usage example**: `%papiminicolors_section_server_tps_colored%`