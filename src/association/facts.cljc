(ns association.facts
  "Industry rule/history catalog for the Kenya Association of
  Manufacturers (KAM) -- a 51st industry-association-level source
  (see cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni for the first eight) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The NINTH entry aligned
  to ISIC 9411 (activities of business, employers, and professional
  membership organizations). Fills Kenya's previously-open
  association-axis gap (one of the 19-country gap list recorded at
  tick 143) -- Kenya now has real, individually verified facts
  across ALL THREE axes (country: cloud-itonami-iso3166-ken
  statute.facts; municipality: cloud-itonami-municipality-ken-nairobi;
  association: this entry).

  kam.co.ke's own domain returned a TLS certificate-verification
  error on every page tried (both the bare and www hostnames), so
  neither entry here could be directly confirmed against KAM's own
  site. Instead: the 1959 founding is directly WebFetch-verified
  against Manufacturing Outlook's KAM spotlight article
  (https://www.mfg-outlook.com/manufacturing-spotlights/kenya-association-of-manufacturers-kam-spotlight),
  which quotes KAM's own Chairman (Mucai Kunyiha) verbatim:
  'Established in 1959, we have evolved into a dynamic, vibrant,
  credible and respected business association that unites
  industrialists and offers a common voice for businesses.' --
  independently corroborated by LinkedIn's official company profile
  field 'Founded: 1959', directly read. The 2009 golden-jubilee
  corporate rebrand (50 years since 1959) could not be confirmed via
  any successfully-rendered primary page this tick, but is
  unanimously corroborated across every independent WebSearch result
  checked with zero conflicting alternative date, and is internally
  consistent (1959 + 50 = 2009) -- matching this session's
  established WebSearch-corroboration pattern for cases with no
  successfully-rendered primary alternative (e.g. Nigeria's CAMA 2020
  at tick 117, Czech Republic's Business Corporations Act date at
  tick 139). No personal names of office-holders are persisted here
  (Mucai Kunyiha's name appears only inside a direct attributed
  quote about the organization's founding, not as a standalone
  persisted fact).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"kam"
   [{:association-rule/id "kam.founding-1959"
     :association-rule/title "Kenya Association of Manufacturers (KAM) established in 1959, per KAM's own Chairman quoted directly in Manufacturing Outlook's spotlight article, corroborated by LinkedIn's official 'Founded: 1959' company profile field"
     :association-rule/association "kam"
     :association-rule/isic "9411"
     :association-rule/country "KEN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.mfg-outlook.com/manufacturing-spotlights/kenya-association-of-manufacturers-kam-spotlight"
     :association-rule/url-provenance :mfg-outlook-corroborated
     :association-rule/established-date "1959"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}
    {:association-rule/id "kam.golden-jubilee-rebrand-2009"
     :association-rule/title "KAM unveiled a new corporate image in 2009, marking 50 years since its 1959 establishment (WebSearch-corroborated across multiple independent results, zero conflicting alternative date; kam.co.ke itself returned a TLS certificate-verification error on every page tried this tick)"
     :association-rule/association "kam"
     :association-rule/isic "9411"
     :association-rule/country "KEN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.mfg-outlook.com/manufacturing-spotlights/kenya-association-of-manufacturers-kam-spotlight"
     :association-rule/url-provenance :websearch-corroborated
     :association-rule/established-date "2009"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-ken-kam Wave 0 (ADR-2607141700): "
                 (count (get catalog "kam")) " KAM entries seeded "
                 "with Manufacturing Outlook direct quote + LinkedIn corroboration "
                 "(kam.co.ke itself returned a TLS certificate error on every page tried). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
