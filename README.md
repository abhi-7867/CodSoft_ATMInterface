# Premium ATM Interface System

A comprehensive, professional-grade ATM simulation system built in Java with advanced features and security.

## Features

### Core Functionality
- ✅ **Account Management**: Secure bank account with PIN protection
- ✅ **Withdraw Money**: Validate withdrawals with balance and limit checks
- ✅ **Deposit Money**: Validate deposits with minimum/maximum limits
- ✅ **Check Balance**: Real-time balance inquiry
- ✅ **Transaction History**: Complete transaction logging with timestamps

### Security Features
- 🔒 **PIN Authentication**: Secure PIN verification system
- 🔒 **Account Locking**: Automatic account lock after 3 failed PIN attempts
- 🔒 **Input Validation**: Comprehensive validation for all user inputs
- 🔒 **Transaction Limits**: Enforced minimum and maximum transaction amounts

### Premium Features
- 💎 **Transaction History**: Detailed transaction records with timestamps
- 💎 **Professional UI**: Clean, user-friendly menu-driven interface
- 💎 **Error Handling**: Graceful error handling with informative messages
- 💎 **Multiple Accounts**: Support for multiple bank accounts
- 💎 **Balance Validation**: Prevents overdrafts and ensures account integrity

## System Architecture

### Class Structure

1. **BankAccount.java**
   - Manages account data (account number, PIN, balance)
   - Handles PIN verification and account locking
   - Maintains transaction history
   - Enforces balance constraints

2. **ATM.java**
   - Core ATM machine logic
   - Handles authentication
   - Processes withdrawals, deposits, and balance checks
   - Validates transaction limits
   - Returns structured transaction results

3. **Transaction.java**
   - Represents individual transaction records
   - Stores transaction type, amount, balance, and timestamp
   - Provides formatted transaction display

4. **ATMInterface.java**
   - Main user interface and menu system
   - Handles user input and validation
   - Manages application flow and session handling
   - Provides sample accounts for demonstration

## Usage

```bash
javac *.java
java ATMInterface
```
