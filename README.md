# Proof of Concept: Azure Event Hub Integration

## Overview

This is a simple Proof of Concept (PoC) project that demonstrates how to connect to an Azure Event Hub using Spring Boot and Azure's Event Hub SDK. The application can send and receive messages (events) to/from an Azure Event Hub. It contains two main components:

1. **Producer**: Responsible for sending messages to the Azure Event Hub.
2. **Consumer**: Listens for incoming messages from the Azure Event Hub.

This project uses **Spring Cloud Azure** libraries to make the interaction with Azure services easier and more efficient.

---

## Azure Setup Guide

Follow these steps to set up Azure Event Hub and related resources:

### 1. Create an Azure Resource Group

1. Go to the [Azure portal](https://portal.azure.com).
2. Search for **Resource Groups** in the search bar.
3. Click **Create** and fill in the details:
   - **Resource group name**: `your-resource-group`
   - **Region**: Choose a location that fits your requirements.
4. Click **Review + Create** and then **Create**.

### 2. Create an Event Hub Namespace

1. In the Azure portal, search for **Event Hubs** and click on **Event Hubs**.
2. Click **Create**.
3. Select the **Subscription** and **Resource Group** created earlier.
4. Under **Namespace Details**:
   - **Namespace Name**: `small-poc-event-hub`
   - **Pricing Tier**: Choose the appropriate tier (e.g., Basic).
5. Click **Review + Create** and then **Create**.

### 3. Create an Event Hub

1. Once the namespace is created, go to your newly created namespace (`small-poc-event-hub`).
2. Under the **Entities** section, click on **Event Hubs**.
3. Click **+ Event Hub** to create a new event hub.
4. Set the **Event Hub Name** to `poc-eventhub`.
5. Leave other configurations as default and click **Create**.

### 4. Create a Storage Account and Blob Container

The Azure Event Hub uses a Blob Storage account for checkpointing, which helps maintain the state of event processing.

1. In the Azure portal, search for **Storage accounts**.
2. Click **Create** and select your subscription and resource group.
3. Under **Storage Account Details**:
   - **Storage account name**: `smalleventhub`
   - **Region**: Same region as the Event Hub.
4. Click **Review + Create** and then **Create**.

5. After the storage account is created, go to the **Containers** section.
6. Create a new container:
   - **Container Name**: `small-eventhub`
   - **Public Access Level**: Private (no anonymous access).
7. Click **Create**.

---

## Build and Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ErminaTrontzou/poc-azure-event-hub
   mvn clean install
   mvn spring-boot:run
2. Run a post command
  ```bash
    curl -X POST http://localhost:8080/api/events/send -d "Your message here" -H "Content-Type: text/plain"
