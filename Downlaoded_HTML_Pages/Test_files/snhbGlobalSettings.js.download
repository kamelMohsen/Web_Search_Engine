var snhb = snhb || {};
snhb.globalSettings = {  
    currencyConversionEURTo: {
        // http://sdw.ecb.europa.eu/quickview.do?SERIES_KEY=120.EXR.M.USD.EUR.SP00.A
        USD: { year: 2020, month: 04, rate: 1.0862 },
        AUD: { year: 2020, month: 04, rate: 1.7271 },
        NZD: { year: 2020, month: 04, rate: 1.8109 }
    },
    hbCPMMin: 0.05,
    bidderAdjustments: {
        "default": { c: "USD", s: 0.00 },
        "adform": { c: "USD", s: 0.15 },
        "criteo": { c: "EUR", s: 0.00 },
        "districtm": { c: "USD", s: 0.15 },
		"districtmDMX": { c: "USD", s: 0.15 },
		"districtmAnxAst": { c: "USD", s: 0.15 },
		"fidelity": { c: "USD", s: 0.30 },
        "openx": { c: "EUR", s: 0.00 },
        "pixfuture": { c: "USD", s: 0.40 },
        "rubicon": { c: "USD", s: 0.20 },
        "smartadserver": { c: "USD", s: 0.15 },
		"teads": { c: "EUR", s: 0.00 }
    },
    minSafeRefreshIntervalMs: 420000,
    ssr: {
        refreshWithVisMaxMs: 420000,
        blacklist: ["snigelcampaign", "SekindoSPlayer", "live.sekindo.com", "connatix", "carambo.la", "vidazoo"]
    },
    gdpr: {
        eeaCookieName: "snhbFromEEA",
        eeaCookieExpiresSeconds: 172800,
        cmpFullConsent: "snhbCmpFullConsent",
        cmpConsentsCookieName: "euconsent",
        reconsiderationAppealIntervalCookieName: "snReconsiderAppealMuted",
        reconsiderationAppealCookieName: "snReconsiderAppealEnabled",
        googleId: 1000,
        snVendorIds: [ 25, 50, 32, 56, 138, 24, 144, 10, 62, 69, 76, 81, 36, 52, 45, 13, 228, 104, 253 ]
    }
};
snhb.console.debug("Global settings loaded.");

