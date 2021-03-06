package com.braintreegateway;

import com.braintreegateway.Subscription.Source;
import com.braintreegateway.Subscription.Status;
import com.braintreegateway.util.EnumUtils;
import com.braintreegateway.util.NodeWrapper;

import java.math.BigDecimal;
import java.util.Calendar;

public class SubscriptionStatusEvent {
    private BigDecimal balance;
    private BigDecimal price;
    private Calendar timestamp;
    private Source source;
    private Status status;
    private String user;

    public SubscriptionStatusEvent(NodeWrapper node) {
        balance = node.findBigDecimal("balance");
        price = node.findBigDecimal("price");
        status = EnumUtils.findByName(Status.class, node.findString("status"), Status.UNRECOGNIZED);
        timestamp = node.findDateTime("timestamp");
        source = EnumUtils.findByName(Source.class, node.findString("subscription-source"), Source.UNRECOGNIZED);
        user = node.findString("user");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public Source getSource() {
        return source;
    }

    public String getUser() {
        return user;
    }
}
