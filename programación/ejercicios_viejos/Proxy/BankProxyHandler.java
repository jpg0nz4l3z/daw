package Proxy;

// BankProxyHandler.java

import java.lang.reflect.*;
import java.util.*;

// “InvocationHandler” required by the proxy API.
public class BankProxyHandler implements InvocationHandler {
    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }

    // Method defined in InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("getAccounts")) {
            bank.setAccounts(getAccountsFromDatabase());
            return bank.getAccounts();
        } else if (methodName.equals("setAccounts")) {
            bank.setAccounts((Collection<Account>) args[0]);
            setAccountsToDatabase(bank.getAccounts());
            return null;
        } else {
        }
        return proxy;
    }

    // Lots of details here:
    protected Collection<Account> getAccountsFromDatabase() {

        return List.of();
    }

    protected void setAccountsToDatabase(Collection<Account> accounts) {

    }

    static void main() {
        Bank bank = (Bank) Proxy.newProxyInstance(
                Bank.class.getClassLoader(),
                new Class[]{Bank.class},
                new BankProxyHandler(new BankImpl()));
    }
}