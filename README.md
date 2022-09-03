# k8s-practice
Horribly written spring boot apps for the purpose of learning k8s

## Secrets
Decrypt and apply secrets
`sops --decrypt admin/secret.enc.yaml | kubectl apply -f -`
