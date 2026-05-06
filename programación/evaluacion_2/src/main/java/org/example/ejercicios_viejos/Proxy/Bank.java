package org.example.ejercicios_viejos.Proxy;// Bank.java (suppressing package names...)

import java.util.*;
// The abstraction of a bank.
public interface Bank {
    Collection<Account> getAccounts();
    void setAccounts(Collection<Account> accounts);
}