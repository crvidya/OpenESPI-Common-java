package org.energyos.espi.common.domain;

public class Routes {
    public static final String DEFAULT = "/default";
    public static final String HOME = "/home";
    public static final String LOGIN = "/login";
    public static final String ROOT = "/";

    public static final String DATA_CUSTODIAN_API_FEED = "/api/feed";
    public static final String DATA_CUSTODIAN_AUTHORIZATION = "/espi/1_1/resource/Authorization/{AuthorizationID}";
    public static final String DATA_CUSTODIAN_HOME = "/custodian/home";
    public static final String DATA_CUSTODIAN_NOTIFY_THIRD_PARTY = "/espi/1_1/NotifyThirdParty";
    public static final String DATA_CUSTODIAN_REMOVE_ALL_OAUTH_TOKENS = "/custodian/removealltokens";
    public static final String DATA_CUSTODIAN_REST_SUBSCRIPTION_GET = "/espi/1_1/resource/Subscription/{subscriptionHashedId}";
    public static final String DATA_CUSTODIAN_REST_USAGE_POINT_COLLECTION = "/espi/1_1/resource/RetailCustomer/{retailCustomerId}/UsagePoint";
    public static final String DATA_CUSTODIAN_REST_USAGE_POINT_CREATE = "/espi/1_1/resource/RetailCustomer/{retailCustomerId}/UsagePoint";
    public static final String DATA_CUSTODIAN_REST_USAGE_POINT_GET = "/espi/1_1/resource/RetailCustomer/{RetailCustomerID}/UsagePoint/{UsagePointID}";
    public static final String DATA_CUSTODIAN_REST_USAGE_POINT_MEMBER = "/espi/1_1/resource/RetailCustomer/{retailCustomerHashedId}/UsagePoint/{usagePointHashedId}";
    public static final String DATA_CUSTODIAN_REST_USAGE_POINT_UPDATE = "/espi/1_1/resource/RetailCustomer/{retailCustomerHashedId}/UsagePoint/{usagePointHashedId}";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_CREATE = "/custodian/retailcustomers/create";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_FORM = "/custodian/retailcustomers/form";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_INDEX = "/custodian/retailcustomers";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_SHOW = "/custodian/retailcustomers/{retailCustomerId}/show";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_USAGE_POINTS_CREATE = "/custodian/retailcustomers/{retailCustomerId}/usagepoints/create";
    public static final String DATA_CUSTODIAN_RETAIL_CUSTOMER_USAGE_POINTS_FORM = "/custodian/retailcustomers/{retailCustomerId}/usagepoints/form";
    public static final String DATA_CUSTODIAN_SCOPE_SELECTION_SCREEN = "/RetailCustomer/ScopeSelectionList";
    public static final String DATA_CUSTODIAN_SUBSCRIPTION = "/espi/1_1/resource/Subscription/{subscriptionHashedId}";
    public static final String DATA_CUSTODIAN_UPLOAD = "/custodian/upload";

    public static final String THIRD_PARTY_AUTHORIZATION = "/RetailCustomer/{retailCustomerID}/AuthorizationList";
    public static final String THIRD_PARTY_BATCH_LIST = "/batchLists";
    public static final String THIRD_PARTY_DATA_CUSTODIAN_LIST = "/RetailCustomer/{retailCustomerID}/DataCustodianList";
    public static final String THIRD_PARTY_LIST = "/RetailCustomer/{retailCustomerId}/ThirdPartyList";
    public static final String THIRD_PARTY_METER_READINGS_SHOW = "/meterreadings/{meterReadingId}/show";
    public static final String THIRD_PARTY_NOTIFICATION = "/espi/1_1/Notification";
    public static final String THIRD_PARTY_OAUTH_CODE_CALLBACK = "/espi/1_1/OAuthCallBack";
    public static final String THIRD_PARTY_SCOPE_SELECTION_SCREEN = "/RetailCustomer/ScopeSelection";
    public static final String THIRD_PARTY_SCOPE_SELECTION_SCREEN_WITH_RETAIL_CUSTOMER_ID = "/RetailCustomer/{retailCustomerId}/ScopeSelection";

    public static final String AUTHORIZATION_SERVER_AUTHORIZATION_ENDPOINT = "/oauth/authorize";
    public static final String AUTHORIZATION_SERVER_TOKEN_ENDPOINT = "/oauth/token";
    public static final String METER_READINGS_SHOW = "/RetailCustomer/{retailCustomerId}/meterreadings/{meterReadingId}/show";
    public static final String OAUTH_ACCESS = "/oauth/confirm_access";
    public static final String OAUTH_ERROR = "/oauth/error";
    public static final String RETAIL_CUSTOMER_HOME = "/RetailCustomer/{retailCustomerId}/home";
    public static final String TERMS_OF_SERVICE = "/TermsOfService";
    public static final String USAGE_POINT_FEED = "/RetailCustomer/{retailCustomerId}/UsagePoint/feed";
    public static final String USAGE_POINT_INDEX = "/RetailCustomer/{retailCustomerId}/UsagePoint";
    public static final String USAGE_POINT_INDEX_TP = "/RetailCustomer/{retailCustomerId}/UsagePoint/show";
    public static final String USAGE_POINT_SHOW = "/RetailCustomer/{retailCustomerId}/UsagePoint/{usagePointId}/show";
    public static final String USAGE_POINT_SHOW_TP = "/RetailCustomer/{retailCustomerId}/UsagePoint/{UsagePointHashedId}/show";
    public static final String USAGE_POLICY = "/UsagePolicy";

    public static String buildDataCustodianRESTUsagePointCollection(String retailCustomerHashedId) {
        return DATA_CUSTODIAN_REST_USAGE_POINT_COLLECTION.replace("{retailCustomerId}", retailCustomerHashedId);
    }

    public static String buildDataCustodianRESTUsagePointMember(String retailCustomerHashedId, String usagePointHashedId) {
        return DATA_CUSTODIAN_REST_USAGE_POINT_MEMBER.replace("{retailCustomerHashedId}", retailCustomerHashedId).replace("{usagePointHashedId}", usagePointHashedId);
    }

    public static String buildDataCustodianSubscription(String subscriptionHashedId) {
        return DATA_CUSTODIAN_SUBSCRIPTION.replace("{subscriptionHashedId}", subscriptionHashedId);
    }

    public static String buildDataCustodianRESTUsagePointGet(String retailCustomerId, String usagePointId) {
        return DATA_CUSTODIAN_REST_USAGE_POINT_GET.replace("{RetailCustomerID}", retailCustomerId).replace("{UsagePointID}", usagePointId);
    }

    public static String buildThirdPartyAuthorization(String retailCustomerId) {
        return THIRD_PARTY_AUTHORIZATION.replace("{retailCustomerID}", retailCustomerId);
    }

    public static String getDataCustodianRESTSubscriptionGetURL(String subscriptionHashedId) {
        return DATA_CUSTODIAN_REST_SUBSCRIPTION_GET.replace("{subscriptionHashedId}", subscriptionHashedId);
    }
}

