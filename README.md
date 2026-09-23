# cloud-itonami-assoc-9411-ken-kam

Industry rule/history catalog for the **Kenya Association of
Manufacturers** (KAM) — the NINTH entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-sau-fsc`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-sau-fsc)
(Saudi Arabia),
[`-9411-aut-wko`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-aut-wko)
(Austria),
[`-9411-irl-ibec`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-irl-ibec)
(Ireland),
[`-9411-nzl-businessnz`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nzl-businessnz)
(New Zealand),
[`-9411-cze-spcr`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-cze-spcr)
(Czech Republic),
[`-9411-ind-cii`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ind-cii)
(India),
[`-9411-zaf-busa`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-zaf-busa)
(South Africa), and
[`-9411-bra-cni`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-bra-cni)
(Brazil). Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact
family (ADR-2607141700, `cloud-itonami-compliance-fact-federation`,
in `com-junkawasaki/root`).

## Sourcing note

This repo fills Kenya's previously-open association-axis gap (one of
the 19-country gap list recorded at tick 143). Kenya now has real,
individually verified facts across all three axes: country
([`cloud-itonami-iso3166-ken`](https://github.com/cloud-itonami/cloud-itonami-iso3166-ken)),
municipality
([`cloud-itonami-municipality-ken-nairobi`](https://github.com/cloud-itonami/cloud-itonami-municipality-ken-nairobi)),
and association (this repo).

Fourteen of the fifteen entries cite `kam.co.ke` itself (About Us,
Sectors Profile, Regional Offices, Membership Categories, the CEEC and
CGGCC centres, Women in Manufacturing, the Manufacturing Academy and the
TVET programme). The one exception is Manufacturing Outlook's interview
with KAM's Chairman, kept as independent corroboration of the 1959
founding year.

When this catalog was first seeded (2026-07-17) `kam.co.ke` returned a
TLS certificate-verification error on every page tried, so both entries
then rested on Manufacturing Outlook, and the second — a 2009
golden-jubilee rebrand — rested on web-search results alone. On
2026-09-24 `kam.co.ke` answered over verified TLS. The rebrand entry was
**removed**: no page on `kam.co.ke` or Manufacturing Outlook checked
that day describes it, and an entry with no page and no quote cannot be
checked against anything.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on KAM's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `data/datascript-tx.edn` — the catalog, **source of truth**. Facts are
  authored here and nowhere else. Query it alongside other
  `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljk`.
- `src/association/facts.kotoba` — the Clojure reading, **generated**.
- `src/association_facts.kotoba` — the Kotoba port, **generated**; compiles
  with `amu compile src/association_facts.kotoba --target js|wasm32-browser|x86_64-linux|aarch64-macos`.
- `schema/association-rule.edn` — DataScript schema.

Every entry carries the page it came from (`:source-article`) and the
verbatim span the claim rests on (`:source-quote`). To change the catalog:

```bash
# 1. edit data/datascript-tx.edn, then regenerate both readings
kbb --backend sci scripts/gen-kotoba-port.cljk
kbb --backend sci scripts/gen-kotoba-port.cljk --check   # exit 1 if either reading drifted

# 2. check the catalog against its own sources
kbb --backend sci scripts/verify-catalog.cljk            # structural, offline
kbb --backend sci scripts/verify-catalog.cljk --live     # fetch every :url, require every quote
```

`verify-catalog` exits `0` (checked, nothing wrong), `1` (findings
printed) or `2` (REFUSED — could not check, e.g. a source did not
answer 2xx). A `2` is not a pass.

Every page on `kam.co.ke` carries the same navigation menu and footer
("the voice of manufacturing in Kenya since 1959"), so a quote copied
from those would be "on" every page and support nothing. Quotes are
taken from each page's own body, and `--live` fetches a path that
cannot exist on each origin as a soft-404 control.

`kbb -M:test` finds no test namespace in this repository (the tests are
`.kotoba` since the 2026-09-10 rename), so `--check` and `--live` are
the gates that actually run here.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains KAM's; this repo stores only citation metadata
(id/title/url/dates), not full text.
