
zkgrails.useEventThread = true
    
zkgrails.threadLocalSynchronization = [
    'org.springframework.transaction.support.TransactionSynchronizationManager': [
        'resources', 
        'synchronizations',
        'currentTransactionName',
        'currentTransactionReadOnly',
        'actualTransactionActive'
    ],
    'org.springframework.orm.hibernate3.SessionFactoryUtils': [
        'deferredCloseHolder'
    ],
    'org.springframework.transaction.interceptor.TransactionAspectSupport': [
    ],
    'org.springframework.web.context.request.RequestContextHolder': [
        'requestAttributesHolder',
        'inheritableRequestAttributesHolder'
    ],
    'org.springframework.security.context.ThreadLocalSecurityContextHolderStrategy': [
        'contextHolder'
    ]
]

zkgrails.listener = [
     "ThreadLocal Synchronization Listener": org.zkoss.zkplus.util.ThreadLocalListener
]

// <?xml version="1.0" encoding="UTF-8"?>
// <zk>
//     <system-config>
//         <disable-event-thread/>
//     </system-config>
//     <listener>
//         <description>ThreadLocal Synchronization Listener</description>
//         <listener-class>org.zkoss.zkplus.util.ThreadLocalListener</listener-class>
//     </listener>
//     <zscript-config>
//         <language-name>GroovyGrails</language-name>
//         <interpreter-class>
//             org.zkoss.zkgrails.scripting.GroovyGrailsInterpreter
//         </interpreter-class>
//     </zscript-config>
//     <preference>
//             <name>ThreadLocal</name>
//             <value>
//                 org.springframework.transaction.support.TransactionSynchronizationManager=resources,
//                 synchronizations,currentTransactionName,currentTransactionReadOnly,actualTransactionActive;
//                 org.springframework.orm.hibernate3.SessionFactoryUtils=deferredCloseHolder;
//                 org.springframework.transaction.interceptor.TransactionAspectSupport=transactionInfoHolder;
//                 // org.springframework.web.context.request.RequestContextHolder=requestAttributesHolder,inheritableRequestAttributesHolder;
//                 org.springframework.security.context.ThreadLocalSecurityContextHolderStrategy=contextHolder;
//             </value>
//     </preference>
// </zk>