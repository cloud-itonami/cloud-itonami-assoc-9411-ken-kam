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

`kam.co.ke`'s own domain returned a TLS certificate-verification
error on every page tried this tick (both bare and `www` hostnames).
The 1959 founding was instead directly WebFetch-verified against
Manufacturing Outlook's KAM spotlight article, which quotes KAM's own
Chairman verbatim. The 2009 golden-jubilee rebrand is
WebSearch-corroborated only (zero conflicting alternative date,
internally consistent with 1959+50) — matching this session's
established pattern for cases with no successfully-rendered primary
alternative.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on KAM's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains KAM's; this repo stores only citation metadata
(id/title/url/dates), not full text.
